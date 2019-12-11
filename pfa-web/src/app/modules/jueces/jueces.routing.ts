import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JuecesIndexComponent } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: JuecesIndexComponent,
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class JuecesRoutingModule { }