import { IProduct } from 'app/shared/model/product.model';

export interface IOrder {
  id?: number;
  product?: string;
  unitPrice?: string;
  quantity?: number;
  total?: string;
  order_products?: IProduct[] | null;
  product_prices?: IProduct[] | null;
}

export const defaultValue: Readonly<IOrder> = {};
