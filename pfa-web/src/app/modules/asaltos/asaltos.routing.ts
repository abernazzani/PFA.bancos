import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsaltoIndexComponent } from './pages/index/index.component';
import { AsaltosEditComponent } from './pages/edit/edit.component';

const routes: Routes = [{
    path: '', component: AsaltoIndexComponent,
},
{ path: 'edit/:id', component: AsaltosEditComponent },
{ path: 'edit', component: AsaltosEditComponent }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class AsaltosRoutingModule { }