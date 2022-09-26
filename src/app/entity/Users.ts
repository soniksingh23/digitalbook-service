import { Roles } from "./Roles";

export default class Users {
    constructor(public username: string, public roles: Roles , public email: string, public password: string) { }
}