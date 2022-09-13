import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import User from './entity/User';

const API_URL="http://localhost:8080/user/";
@Injectable({
  providedIn: 'root'
})

export class UserService {
  
  constructor(public client :HttpClient) { }
  saveUser(user: User){

  //  return this.client.post(API_URL,{
  //    // method: 'POST',
  //     //body: JSON.stringify(user),
  //     body: user,
  //     header:{
  //       ['content-type'] : 'application/json'
  //     }
  //   })

  return this.client.post(API_URL, user);
  }

  getUsers(){
    return this.client.get(API_URL);
  }
  deleteUser(userid: number) {
    return this.client.delete(API_URL + userid);
  }
}
