import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioIndexComponent } from './pages/index/index.component';


const routes: Routes = [
    {path: '', component: InicioIndexComponent}
   


]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class InicioRoutingModule { }