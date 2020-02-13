
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosIndexComponent } from './pages/index/index.component';

const routes: Routes = [{
    path: '', component: UsuariosIndexComponent,
}]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class UsuariosRoutingModule { }