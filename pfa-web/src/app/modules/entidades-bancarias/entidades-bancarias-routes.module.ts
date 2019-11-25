import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from 'src/app/shared/components/layout/layout.component';
import { EntidadesBancariasIndexPage } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: EntidadesBancariasIndexPage,
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class BancosRoutesModule { }