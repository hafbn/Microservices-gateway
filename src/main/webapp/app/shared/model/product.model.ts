export interface IProduct {
  id?: number;
  name?: string;
  description?: string | null;
  type?: string;
  price?: string;
}

export const defaultValue: Readonly<IProduct> = {};
