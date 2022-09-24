import { Component, OnInit } from '@angular/core';
import Author from '../entity/Author';
import Book from '../entity/Book';
import Reader from '../entity/Reader';
import { BookService } from '../service/book.service';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})


export class BookformComponent implements OnInit {

  todayDate:Date= new Date();
  author: Author= new Author( "Smith","Smith@gmail.com", 26);
  //reader: Reader = new Reader( 3,"Smith","Smith@gmail.com", 26);
  book:Book= new Book(1, 'The java Today', 550,'Publisher1',this.todayDate,
   'Life History','/abc',true, 'COMIC', false, this.author);
  books:any=[];
  // {{book.title}},{{book.price}}, {{book.price}}, {{book.publisher}}, {{book.publishedDate | date}},
  // {{book.contents}},{{book.imageURL}}, {{book.active}},
  // {{book.category}},{{book.author.name}},{{book.author.age}}
  // {{book.author.authorEmail}}

  displayedColumns: string[] = ['title', 'price', 'publisher','publishedDate', 
  'contents', 'imageURL', 'active','category','authorName','authorEmail','age','action'];
  dataSource:any= [];

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
    
    observable.subscribe(bookList => {
      this.books = bookList;
      this.dataSource= this.books.filter((item: { deleted: boolean; })=>item.deleted!=true);  
    })
  }
  deleteBook(bookid: number) {
    console.log("deleted");
    const observable = this.bookService.deleteBook(bookid);
    observable.subscribe(response => {
      this.getBooks();
     // this.isNotDeleted=1;
      //this.dataSource= this.books;
      
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
