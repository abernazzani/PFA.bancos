
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VigilantesIndexComponent } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: VigilantesIndexComponent,
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class VigilantesRoutingModule { }