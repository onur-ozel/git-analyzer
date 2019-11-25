import { User } from 'src/app/shared/models/user.model';

export class Repository {
  id: number;
  name: string;
  fullName: string;
  isPrivate: boolean;
  owner: User;
  url: string;
  description: string;
  isForked: boolean;
  starGazersCount: number;
  watchersCount: number;
  forksCount: number;
  openIssuesCount: number;
  language: string;
}
