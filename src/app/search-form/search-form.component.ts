import { Component, OnInit } from '@angular/core';
import Author from '../entity/Author';
import Book from '../entity/Book';
import { BookService } from '../service/book.service';
@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.scss']
})
export class SearchFormComponent implements OnInit {
  todayDate:Date= new Date();
  author: Author= new Author( 3,"Smith","Smith@gmail.com", 26);
  // book: any = {
  //   category: null,
  //   price: null,
  //   publisher: null
    
  // };
  book:Book= new Book(1, 'The java Today', 550,'Publisher1',this.todayDate,
   'Life History','abc',true, 'COMIC',false, this.author);
  books:any=[];
  constructor(public bookService:BookService) { }
  ngOnInit(): void {
  }

  searchBook(category: string, author:Author, price:number, publisher:string) {
    //category: string, price:number, publisher:string
    //const { username, password } = this.form;
    const observable = this.bookService.searchBook(category,author,price, publisher);
    console.log(observable);
    observable.subscribe(books => {
      console.log(books);
      this.books = books;
      // this.getBooks();
    })
  }

}
