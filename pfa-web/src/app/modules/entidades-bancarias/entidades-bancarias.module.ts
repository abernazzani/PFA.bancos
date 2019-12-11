import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared/shared.module';
import { BancosRoutesModule } from './entidades-bancarias-routes.module';
import { Router, RouterModule } from '@angular/router';
import { EntidadesBancariasIndexPage } from './pages/index/index.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { EntidadesBancariasEditComponent } from './pages/edit/edit.component';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [
        SharedModule,
        RouterModule,
        BancosRoutesModule,
        CommonModule,
        FormsModule,
    ],
    exports: [EntidadesBancariasIndexPage,
        EntidadesBancariasEditComponent],
    declarations: [EntidadesBancariasIndexPage,
        EntidadesBancariasEditComponent],
    providers: [],
    entryComponents: [
        EntidadesBancariasEditComponent,
    ]
})
export class BancosModule { }
