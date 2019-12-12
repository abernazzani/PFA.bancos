import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DelincuentesIndexComponent } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: DelincuentesIndexComponent
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class DelincuentesRoutingModule { }