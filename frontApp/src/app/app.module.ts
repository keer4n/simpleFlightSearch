import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './static/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { SearchComponent } from './admin/search/search.component';
import { ResultComponent } from './admin/result/result.component';
import { SrchService } from './admin/srch.service';
import { NgDatepickerModule } from 'ng2-datepicker';
import { HeaderComponent } from './static/header/header.component';
import { ErrorComponent } from './static/error/error.component';

@NgModule({
  declarations: [
    AppComponent, FooterComponent, SearchComponent, SearchComponent, ResultComponent, HeaderComponent, ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgDatepickerModule
  ],
  providers: [SrchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
