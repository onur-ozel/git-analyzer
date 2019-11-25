import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopStarrredReposComponent } from './top-starrred-repos.component';

describe('TopStarrredReposComponent', () => {
  let component: TopStarrredReposComponent;
  let fixture: ComponentFixture<TopStarrredReposComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopStarrredReposComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopStarrredReposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
