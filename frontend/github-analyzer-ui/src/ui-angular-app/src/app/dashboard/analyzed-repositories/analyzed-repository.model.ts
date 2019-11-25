import { Repository } from 'src/app/shared/models/repository.model';

export class AnalyzedRepository extends Repository {
  commitsCount: number;
  pullsCount: number;
  contributersCount: number;
}
