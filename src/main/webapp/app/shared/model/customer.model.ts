export interface ICustomer {
  id?: number;
  idCustomer?: string;
  name?: string;
  telephone?: string;
  mail?: string | null;
}

export const defaultValue: Readonly<ICustomer> = {};
