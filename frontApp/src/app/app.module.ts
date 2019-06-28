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

@NgModule({
  declarations: [
    AppComponent, FooterComponent, SearchComponent, SearchComponent, ResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [SrchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
