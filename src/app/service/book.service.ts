import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Author from '../entity/Author';
import Book from '../entity/Book';
const GET_URL="http://localhost:8085/api/v1/digitalbooks/books/";
const POST_URL="http://localhost:8085/api/v1/digitalbooks/author/books/";
//const SEARCH_URL= "http://localhost:8085/api/v1/digitalbooks/books/search?category=NOVEL&author=John William&price=500&publisher=Publisher1";
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(public client :HttpClient) { }
  saveBook(book: Book){
    return this.client.post(POST_URL, book);
  
  }

  getBooks(){
    return this.client.get(GET_URL);
  }
  deleteBook(bookid: number) {
    return this.client.delete(GET_URL + bookid);
  }

  searchBook(category: string, author:Author, price:number, publisher:string){
    //return this.client.get(GET_URL+"search?category="+category+"&author="+author+"&price="+price+"&publisher="+publisher);
    return this.client.get(GET_URL+"search?category="+category+"&author="+author.name+"&price="+price+"&publisher="+publisher);
    
    //return this.client.get(SEARCH_URL);
  }

}
