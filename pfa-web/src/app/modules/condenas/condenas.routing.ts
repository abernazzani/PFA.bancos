import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CondenasIndexComponent } from './pages/index/index.component';
import { CondenasEditComponent } from './pages/edit/edit.component';

const routes: Routes = [
    {path: '', component: CondenasIndexComponent},
    {path: 'edit', component: CondenasEditComponent}

]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class CondenasRoutingModule { }

