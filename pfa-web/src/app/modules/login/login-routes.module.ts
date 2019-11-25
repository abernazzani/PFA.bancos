import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { LayoutComponent } from 'src/app/shared/components/layout/layout.component';

const routes: Routes = [
    {
        path: '', component: LoginPageComponent
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class LoginRoutesModule { }