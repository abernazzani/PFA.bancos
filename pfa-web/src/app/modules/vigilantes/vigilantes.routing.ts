import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VigilantesIndexComponent } from './pages/index/index.component';
import { VigilantesEditComponent } from './pages/edit/edit.component';

const routes: Routes = [
    {path: '', component: VigilantesIndexComponent},
    {path: 'edit', component: VigilantesEditComponent}


]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class VigilantesRoutingModule { }