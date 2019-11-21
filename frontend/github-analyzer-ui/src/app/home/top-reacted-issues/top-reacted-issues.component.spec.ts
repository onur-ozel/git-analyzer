import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopReactedIssuesComponent } from './top-reacted-issues.component';

describe('TopReactedIssuesComponent', () => {
  let component: TopReactedIssuesComponent;
  let fixture: ComponentFixture<TopReactedIssuesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopReactedIssuesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopReactedIssuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
