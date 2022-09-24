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
  author: Author= new Author( "Smith","Smith@gmail.com", 26);
  errorMessage = '';
  isNotDeleted = 0;
  isSearchBookFailed = false;

  
  displayedColumns: string[] = ['title', 'price', 'publisher','publishedDate', 
  'contents', 'imageURL', 'active','category','authorName','authorEmail','age'];
  dataSource:any= [];


  book:Book= new Book(1, 'The java Today', 550,'Publisher1',this.todayDate,
   'Life History','abc',true, 'COMIC',false, this.author);
  books:any=[];
  constructor(public bookService:BookService) { }
  ngOnInit(): void {
  }

  searchBook(category: string, author:Author, price:number, publisher:string) {
    
    const observable = this.bookService.searchBook(category,author,price, publisher);
    console.log(observable);
    observable.subscribe(books => {
      console.log(books);
      this.books = books;
     // this.dataSource= this.books;
     this.dataSource= this.books.filter((item: { deleted: boolean; })=>item.deleted!=true);  
      // this.getBooks();
    })
  }

}
