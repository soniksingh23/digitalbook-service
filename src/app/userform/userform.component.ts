import { Component, OnInit } from '@angular/core';
import User from '../entity/User';
import { UserService } from '../user.service';



@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.scss']
})
export class UserformComponent  {
  user:User= new User('Ram', 20, 'ram@email.com');
  users:any=[];
  constructor(public userService:UserService) { }

  ngOnInit(): void {//called only once during initilization of component
    this.getUsers();
    //more logic which needs to run only once
  }
  private getUsers() {
    const observable = this.userService.getUsers();
    observable.subscribe(users => {
      this.users = users;
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
    },
    (error)=>{ // Error Handler
      alert("something went wrong !");
    }
    )
  }

}

