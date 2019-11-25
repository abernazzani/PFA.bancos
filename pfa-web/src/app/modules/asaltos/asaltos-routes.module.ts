import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsaltosComponent } from './components/asaltos/asaltos.component';
import { LayoutComponent } from 'src/app/shared/components/layout/layout.component';

const routes: Routes = [
    {
        path: '', component: AsaltosComponent,
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [],
    declarations: [],
})
export class AsaltosRoutesModule { }