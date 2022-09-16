import { Component, OnInit } from '@angular/core';
import Author from '../entity/Author';
import Book from '../entity/Book';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})


export class BookformComponent implements OnInit {

  todayDate:Date= new Date();
  author: Author= new Author( 3,"Smith","Smith@gmail.com", 26);

  book:Book= new Book(1, 'The java Today', 550,'Publisher1',this.todayDate,
   'Life History','/abc',true, 'COMIC', false, this.author);
  books:any=[];
  constructor(public bookService:BookService) { }

  isSuccessful = false;
  isCreateBookFailed = false;
  errorMessage = '';
  isNotDeleted = 0;

  ngOnInit(): void {
    this.getBooks();
   
  }
  private getBooks() {
    const observable = this.bookService.getBooks();
    observable.subscribe(books => {
      this.books = books;
    })
  }
  deleteBook(bookid: number) {
    console.log("deleted");
    const observable = this.bookService.deleteBook(bookid);
    observable.subscribe(response => {
      this.getBooks();
      //isNotDeleted=1;
      
    })
    
  }
  saveBook(){
    console.log("Book Saved in save()");
    //Ajax call
    const observable= this.bookService.saveBook(this.book);
    
    observable.subscribe((response)=>{ //successs Handler
      console.log(response);
      this.isSuccessful = true;
      this.isCreateBookFailed = false;

   // isBookCreateFailed = false;
    // errorMessage = '';
    },

    err => {
      this.errorMessage = err.error.message;
      this.isCreateBookFailed = true;
    }
   
    )
  }
  //  searchBook(category: string) {
  //   const observable = this.bookService.searchBook(category);
  //   console.log(observable);
  //   observable.subscribe(response => {
  //     console.log(response);
  //     this.getBooks();
  //   })
  //}

}
