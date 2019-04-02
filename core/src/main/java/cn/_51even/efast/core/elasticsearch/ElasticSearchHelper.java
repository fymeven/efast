package cn._51even.efast.core.elasticsearch;

import cn._51even.efast.core.system.BasePageRequest;
import com.github.pagehelper.PageInfo;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.annotation.Resource;
import java.util.List;

@Lazy
public class ElasticSearchHelper {

    private static ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        ElasticSearchHelper.elasticsearchTemplate = elasticsearchTemplate;
    }

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchHelper.class);
    /**
     *  respository查询
     * @param pageRequest
     * @param queryBuilder
     * @return
     */
    public static Object repositorySearch(BasePageRequest pageRequest, ElasticsearchRepository elasticsearchRepository, QueryBuilder queryBuilder){
        //构建查询条件
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(queryBuilder);
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        if (pageRequest.getDoSort()){
            //设置排序规则
            FieldSortBuilder sort = SortBuilders.fieldSort(pageRequest.getSortColumn()).order(SortOrder.fromString(pageRequest.getSortRule()));
            nativeSearchQueryBuilder.withSort(sort);
        }
        if (pageRequest.getDoPage()){
            //设置分页条件
            Pageable pageable = PageRequest.of(pageRequest.getPageNum()-1, pageRequest.getPageSize());
            nativeSearchQueryBuilder.withPageable(pageable);
        }
        elasticsearchRepository.search(queryBuilder);
        Page page = elasticsearchRepository.search(searchQuery);
        return parsePage(page);
    }

    /**
     * template 查询
     * @param pageRequest
     * @param criteria
     * @param bean
     * @param <T>
     * @return
     */
    public static <T>Object templateSearch(BasePageRequest pageRequest, Criteria criteria, Class<T> bean){
        CriteriaQuery criteriaQuery = new CriteriaQuery(criteria);
        if (pageRequest.getDoSort()){
            //设置排序规则
            Sort sort = new Sort(Sort.Direction.fromString(pageRequest.getSortRule()), pageRequest.getSortColumn());
            criteriaQuery.addSort(sort);
        }
        if (pageRequest.getDoPage()){
            //设置分页条件
            Pageable pageable = PageRequest.of(pageRequest.getPageNum()-1, pageRequest.getPageSize());
            criteriaQuery.setPageable(pageable);
            Page<T> page = elasticsearchTemplate.queryForPage(criteriaQuery, bean);
            return parsePage(page);
        }else {
            List<T> list = elasticsearchTemplate.queryForList(criteriaQuery, bean);
            return list;
        }
    }

    /**
     * 转换成PageHelper通用分页对象
     * @param page
     * @return
     */
    public static PageInfo parsePage(Page page){
        com.github.pagehelper.Page gitPage = new com.github.pagehelper.Page();
        gitPage.setTotal(page.getTotalElements());
        gitPage.setPages(page.getTotalPages());
        gitPage.setPageNum(page.getPageable().getPageNumber()+1);
        gitPage.setPageSize(page.getPageable().getPageSize());
        gitPage.setStartRow(Integer.valueOf(String.valueOf(page.getPageable().getOffset())));
        PageInfo pageInfo = new PageInfo(gitPage);
        pageInfo.setList(page.getContent());
        return pageInfo;
    }

}
