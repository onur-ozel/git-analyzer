import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from './components/users/users.component';
import { ReadmeComponent } from './components/readme/readme.component';
import { RepositoryComponent } from './components/repository/repository.component';

@NgModule({
  declarations: [UsersComponent, ReadmeComponent, RepositoryComponent],
  imports: [
    CommonModule
  ],
  exports: [
    UsersComponent, ReadmeComponent, RepositoryComponent
  ]
})
export class SharedModule { }
