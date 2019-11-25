import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopFollowedUsersComponent } from './top-followed-users.component';

describe('TopFollowedUsersComponent', () => {
  let component: TopFollowedUsersComponent;
  let fixture: ComponentFixture<TopFollowedUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TopFollowedUsersComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopFollowedUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
