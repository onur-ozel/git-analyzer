import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowerUsersComponent } from './follower-users.component';

describe('FollowerUsersComponent', () => {
  let component: FollowerUsersComponent;
  let fixture: ComponentFixture<FollowerUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FollowerUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FollowerUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
