import { Component, OnInit } from '@angular/core';
import { Roles } from '../entity/Roles';

import Users from '../entity/Users';
import { UsersService } from '../service/users.service';
@Component({
  selector: 'app-newregisterform',
  templateUrl: './newregisterform.component.html',
  styleUrls: ['./newregisterform.component.scss']
})
export class NewregisterformComponent implements OnInit {
  //user:User= new User('ABC', 20, 'abc@gmail.com','****67');

  public RolesEnum = Roles;
  users:Users= new Users('ABC', Roles.ROLE_AUTHOR, 'abc@gmail.com','****67');
  //users:Users= new Users('ABC', 'reader', 'abc@gmail.com','****67');
 
  public roleTypes = Object.values(Roles);
  //users:Users= new Users('ABC',  '\"role\"\: \[\"author\"\]', 'abc@gmail.com','****67');
  user:any=[];
  //roles: any=[];
  userData:any=[];
  roles: string[] = [];
  displayedColumns: string[] = ['name', 'roles[]', 'email', 'password'];
  dataSource:any= [];
  selectedRole: any;
  
  constructor(public usersService:UsersService) { }
  
  isSuccessful = false;
  isUserFormFailed = false;
  errorMessage = '';

  ngOnInit(): void {
    this.getUsers();
    
  }
  private getUsers() {
    const observable = this.usersService.getUsers();
    debugger;
    observable.subscribe(user => {
      this.user = user;
      this.dataSource= this.user;
      console.log(this.dataSource);
    })
  }
  deleteUser(userid: number) {
    console.log("deleted");
    const observable = this.usersService.deleteUser(userid);
    observable.subscribe(response => {
      this.getUsers();
      
    })
    
  }
  convertToApiData(userData: { roles: any; }){
    return {
      ...userData, 
      role: [userData.roles]
    }
  }
  save(){
    console.log("User Saved in save()");
    //Ajax call
    debugger;

   this.userData= this.convertToApiData(this.users);
    const observable= this.usersService.saveUser(this.userData);
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
