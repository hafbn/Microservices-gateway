import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './order.reducer';

export const OrderDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const orderEntity = useAppSelector(state => state.gateway.order.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="orderDetailsHeading">
          <Translate contentKey="gatewayApp.order.detail.title">Order</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{orderEntity.id}</dd>
          <dt>
            <span id="product">
              <Translate contentKey="gatewayApp.order.product">Product</Translate>
            </span>
          </dt>
          <dd>{orderEntity.product}</dd>
          <dt>
            <span id="unitPrice">
              <Translate contentKey="gatewayApp.order.unitPrice">Unit Price</Translate>
            </span>
          </dt>
          <dd>{orderEntity.unitPrice}</dd>
          <dt>
            <span id="quantity">
              <Translate contentKey="gatewayApp.order.quantity">Quantity</Translate>
            </span>
          </dt>
          <dd>{orderEntity.quantity}</dd>
          <dt>
            <span id="total">
              <Translate contentKey="gatewayApp.order.total">Total</Translate>
            </span>
          </dt>
          <dd>{orderEntity.total}</dd>
          <dt>
            <Translate contentKey="gatewayApp.order.order_product">Order Product</Translate>
          </dt>
          <dd>
            {orderEntity.order_products
              ? orderEntity.order_products.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.name}</a>
                    {orderEntity.order_products && i === orderEntity.order_products.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
          <dt>
            <Translate contentKey="gatewayApp.order.product_price">Product Price</Translate>
          </dt>
          <dd>
            {orderEntity.product_prices
              ? orderEntity.product_prices.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.price}</a>
                    {orderEntity.product_prices && i === orderEntity.product_prices.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/order" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/order/${orderEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default OrderDetail;
