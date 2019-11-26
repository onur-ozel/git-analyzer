import { Repo } from 'src/app/shared/models/repo.model';

export class AnalyzedRepo extends Repo {
  commitsCount: number;
  pullsCount: number;
  contributersCount: number;
  analyzeDateTime: Date;
}
