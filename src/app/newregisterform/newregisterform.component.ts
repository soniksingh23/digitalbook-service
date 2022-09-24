import { Component, OnInit } from '@angular/core';

import Users from '../entity/Users';
import { UsersService } from '../service/users.service';
@Component({
  selector: 'app-newregisterform',
  templateUrl: './newregisterform.component.html',
  styleUrls: ['./newregisterform.component.scss']
})
export class NewregisterformComponent implements OnInit {
  //user:User= new User('ABC', 20, 'abc@gmail.com','****67');
 // users:Users= new Users('ABC', 'ROLE_ADMIN', 'abc@gmail.com','****67');
  users:Users= new Users('ABC',  '\"role\"\: \[\"author\"\]', 'abc@gmail.com','****67');
  user:any=[];
  //roles: any=[];

  roles: string[] = [];
  displayedColumns: string[] = ['name', 'roles[]', 'email', 'password'];
  dataSource:any= [];
  
  constructor(public usersService:UsersService) { }
  
  isSuccessful = false;
  isUserFormFailed = false;
  errorMessage = '';

  ngOnInit(): void {
    this.getUsers();
    
  }
  private getUsers() {
    const observable = this.usersService.getUsers();
    observable.subscribe(user => {
      this.user = user;
      this.dataSource= this.user;
    })
  }
  deleteUser(userid: number) {
    console.log("deleted");
    const observable = this.usersService.deleteUser(userid);
    observable.subscribe(response => {
      this.getUsers();
      
    })
    
  }
  save(){
    console.log("User Saved in save()");
    //Ajax call
    const observable= this.usersService.saveUser(this.users);
    observable.subscribe((response)=>{ //successs Handler
      console.log(response);
      this.isSuccessful = true;
      this.isUserFormFailed = false;
    },
    err => {
      this.errorMessage = err.error.message;
      this.isUserFormFailed = true;
    }
    // (error)=>{ // Error Handler
    //   alert("something went wrong !");
    // }
    )
  }

}
