import { NgModule } from '@angular/core';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { LoginRoutesModule } from './login-routes.module';
import { RouterModule, RouterStateSnapshot } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from 'src/app/shared/shared.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        LoginRoutesModule,
        RouterModule,
        SharedModule,
    ],
    exports: [],
    declarations: [LoginPageComponent],
    providers: [],
})
export class LoginModule { }
