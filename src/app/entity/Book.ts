import Author from "./Author";

export default class Book {
    static price: string;
    
    constructor(public id: number, public title: string, public price: number, public publisher:string, public publishedDate:Date,
     public contents:string, public imageURL: string, public active:boolean, 
        public category:string, private deleted:boolean, public author: Author) { }
}
