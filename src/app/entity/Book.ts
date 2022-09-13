export default class Book {
    constructor(public id: number, public title: string, public price: number, public publisher:string,
        public publishedDate:Date, public contents:string, public imageUrl: string, public active:boolean, 
        public category:string, public author: JSON) { }
}


// private Integer id;

// 	private String title;

// 	private BigDecimal price;

// 	private String publisher;

// 	private Date publishedDate;

// 	private String contents;

// 	private String imageURL;

// 	private boolean active;

// 	@Enumerated(EnumType.STRING)
// 	private Category category;

// 	@OneToOne(cascade = CascadeType.ALL)
// 	@JoinColumn(name = "author_id")
// 	private Author author;