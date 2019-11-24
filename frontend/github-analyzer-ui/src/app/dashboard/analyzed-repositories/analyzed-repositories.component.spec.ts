import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalyzedRepositoriesComponent } from './analyzed-repositories.component';

describe('AnalyzedRepositoriesComponent', () => {
  let component: AnalyzedRepositoriesComponent;
  let fixture: ComponentFixture<AnalyzedRepositoriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnalyzedRepositoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnalyzedRepositoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
