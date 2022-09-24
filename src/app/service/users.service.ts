import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Users from '../entity/Users';


const API_URL="http://localhost:8085/api/auth/signup";
@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(public client :HttpClient) { }
  saveUser(users: Users){

  return this.client.post(API_URL, users);
  }

  getUsers(){
    return this.client.get(API_URL);
  }
  deleteUser(userid: number) {
    return this.client.delete(API_URL + userid);
  }
}
