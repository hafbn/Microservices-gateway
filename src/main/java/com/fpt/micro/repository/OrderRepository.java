package com.fpt.micro.repository;

import com.fpt.micro.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Order entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Long>, OrderRepositoryInternal {
    @Override
    Mono<Order> findOneWithEagerRelationships(Long id);

    @Override
    Flux<Order> findAllWithEagerRelationships();

    @Override
    Flux<Order> findAllWithEagerRelationships(Pageable page);

    @Query(
        "SELECT entity.* FROM jhi_order entity JOIN rel_jhi_order__order_product joinTable ON entity.id = joinTable.order_product_id WHERE joinTable.order_product_id = :id"
    )
    Flux<Order> findByOrder_product(Long id);

    @Query(
        "SELECT entity.* FROM jhi_order entity JOIN rel_jhi_order__product_price joinTable ON entity.id = joinTable.product_price_id WHERE joinTable.product_price_id = :id"
    )
    Flux<Order> findByProduct_price(Long id);

    @Override
    <S extends Order> Mono<S> save(S entity);

    @Override
    Flux<Order> findAll();

    @Override
    Mono<Order> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface OrderRepositoryInternal {
    <S extends Order> Mono<S> save(S entity);

    Flux<Order> findAllBy(Pageable pageable);

    Flux<Order> findAll();

    Mono<Order> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Order> findAllBy(Pageable pageable, Criteria criteria);

    Mono<Order> findOneWithEagerRelationships(Long id);

    Flux<Order> findAllWithEagerRelationships();

    Flux<Order> findAllWithEagerRelationships(Pageable page);

    Mono<Void> deleteById(Long id);
}
