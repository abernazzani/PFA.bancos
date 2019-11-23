import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BandasIndexComponent } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: BandasIndexComponent,
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class BandasRoutingModule { }