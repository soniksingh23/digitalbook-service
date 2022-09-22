import { Component, OnInit } from '@angular/core';
import User from '../entity/User';
import { UserService } from '../user.service';
@Component({
  selector: 'app-newregisterform',
  templateUrl: './newregisterform.component.html',
  styleUrls: ['./newregisterform.component.scss']
})
export class NewregisterformComponent implements OnInit {
  user:User= new User('ABC', 20, 'abc@gmail.com','****67');
  users:any=[];

   displayedColumns: string[] = ['name', 'age', 'email', 'password'];
  dataSource:any= [];
  constructor(public userService:UserService) { }
  
  isSuccessful = false;
  isUserFormFailed = false;
  errorMessage = '';

  ngOnInit(): void {//called only once during initilization of component
    this.getUsers();
    //more logic which needs to run only once
  }
  private getUsers() {
    const observable = this.userService.getUsers();
    observable.subscribe(users => {
      this.users = users;
      this.dataSource= this.users;
    })
  }
  deleteUser(userid: number) {
    console.log("deleted");
    const observable = this.userService.deleteUser(userid);
    observable.subscribe(response => {
      this.getUsers();
      
    })
    
  }
  save(){
    console.log("User Saved in save()");
    //Ajax call
    const observable= this.userService.saveUser(this.user);
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
