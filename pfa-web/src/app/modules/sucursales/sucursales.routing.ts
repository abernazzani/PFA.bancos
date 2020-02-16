import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SucursalesIndexComponent } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: SucursalesIndexComponent
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class SucursalesRoutingModule { }