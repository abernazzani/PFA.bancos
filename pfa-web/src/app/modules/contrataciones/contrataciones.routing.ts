import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContratacionesIndexComponent } from './pages/index/index.component';
import { ContratacionesEditComponent } from './pages/edit/edit.component';

const routes: Routes = [
    {path: '', component: ContratacionesIndexComponent},
    {path: 'edit', component: ContratacionesEditComponent}

]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class ContratacionesRoutingModule { }

