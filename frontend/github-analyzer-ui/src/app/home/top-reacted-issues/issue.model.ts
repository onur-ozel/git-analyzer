import { User } from 'src/app/shared/models/user.model';

export class Issue {
  title: string;
  body: string;
  commentCount: number;
  updatedAt: Date;
  createdAt: Date;
  issiueNo: number;
  isLocked: boolean;
  url: string;
  user: User;
}
