package com.onur.scout24.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.onur.scout24.model.AnalyzedRepository;
import com.onur.scout24.repository.AnalyzedRepositoryRepository;

// import com.deposit.infrastructure.utils.ApiUtils;
// import com.deposit.infrastructure.utils.Json;
// import com.deposit.models.DemandDepositAccount;
// import com.deposit.repositories.DemandDepositAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyzedRepositoryService {
    @Autowired
    AnalyzedRepositoryRepository repository;

    @PersistenceContext
    private EntityManager em;

    public void add(AnalyzedRepository repo) {
        repository.save(repo);
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public AnalyzedRepository getById(String id) {
        return repository.findOne(id);
    }

    // public void update(DemandDepositAccount account) {
    // DemandDepositAccount originalAccount =
    // repository.findById(account.getId()).get();

    // originalAccount = account;

    // repository.save(originalAccount);
    // }

    // public String get(Integer offset, Integer limit, String sorts, String fields,
    // String searches) throws Exception {
    // Boolean hasPaging = offset != null && limit != null;
    // Boolean hasSort = sorts != null && !sorts.isEmpty();
    // Boolean hasSearch = searches != null && !searches.isEmpty();

    // List<DemandDepositAccount> returnData;

    // CriteriaBuilder cb = em.getCriteriaBuilder();

    // CriteriaQuery<DemandDepositAccount> cq =
    // cb.createQuery(DemandDepositAccount.class);
    // Root<DemandDepositAccount> account = cq.from(DemandDepositAccount.class);

    // cq.select(account);

    // if (hasSort) {
    // cq.orderBy(ApiUtils.parseSort(sorts, cb, account));
    // }

    // if (hasSearch) {
    // cq.where(ApiUtils.parseSearches(searches, cb, account));
    // }

    // TypedQuery<DemandDepositAccount> typedQuery = em.createQuery(cq);

    // if (hasPaging) {
    // typedQuery.setFirstResult(offset);
    // typedQuery.setMaxResults(limit);
    // }

    // returnData = typedQuery.getResultList();

    // Json.serializer().setFilterProvider(ApiUtils.parseFields(fields,
    // "demandDepositFilter"));

    // return Json.serializer().toString(returnData);
    // }

    // public String getById(String id) {
    // Json.serializer().setFilterProvider(ApiUtils.parseFields("",
    // "demandDepositFilter"));

    // return Json.serializer().toString(repository.findById(id).get());
    // }
}
