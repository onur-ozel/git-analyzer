import { User } from '../top-reacted-issues/user.model';

export class Repository {
  name: string; // name
  fullName: string; // full_name
  isPrivate: boolean; // private
  url: string; // html_url
  description: string; // description
  isForked: boolean; // fork
  starGazersCount: number; // stargazers_count
  watchersCount: number; // watchers_count
  forksCount: number; // forks_count
  openIssuesCount: number; // open_issues_count
  language: string; // language
  owner: User;
}
