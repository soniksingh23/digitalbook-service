import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserformComponent } from './userform/userform.component';
import { HeaderComponent } from './Header/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { FooterComponent } from './Footer/footer/footer.component';
import {HttpClientModule} from '@angular/common/http';
import { EmailformComponent } from './emailform/emailform.component';
import { BookformComponent } from './bookform/bookform.component';
import { RouterModule, Routes } from '@angular/router';
import { SearchFormComponent } from './search-form/search-form.component';
import { LoginComponent } from './login/login.component';
import {MatTableModule} from '@angular/material/table';
import { NewregisterformComponent } from './newregisterform/newregisterform.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardAuthorComponent } from './board-author/board-author.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardReaderComponent } from './board-reader/board-reader.component';

const routes: Routes=[
  {path:'userform',component: UserformComponent},
  {path:'emailform',component: EmailformComponent},
  {path:'bookform',component: BookformComponent},
  {path:'search-form',component: SearchFormComponent},
  {path:'header',component: HeaderComponent},
  {path:'login',component: LoginComponent},
  {path:'newregisterform',component: NewregisterformComponent},
  {path:'profile',component: ProfileComponent},
  {path:'board-admin',component: BoardAdminComponent},

]

@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    HeaderComponent,
    FooterComponent,
    EmailformComponent,
    BookformComponent,
    SearchFormComponent,
    LoginComponent,
    NewregisterformComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardAuthorComponent,
    BoardUserComponent,
    BoardReaderComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, BrowserAnimationsModule,MatTableModule,
    MatButtonModule,MatToolbarModule,HttpClientModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }