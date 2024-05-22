@param String value
@param String tooltip

<div data-xt-tooltip="{ mouseParent: true, duration: 300, delay: 50, position: 'bottom-start' }">
  <input type="button" value="${value}" data-xt-tooltip-element>

  <div class="xt-tooltip p-3 group" data-xt-tooltip-target>
    <div class="xt-card rounded-md shadow-md text-white xt-links-inverse font-medium bg-black opacity-0 group-dir-before:translate-x-4 group-dir-after:-translate-x-4 group-in:transition group-in:duration-300 group-in:opacity-100 group-in:translate-x-0 group-out:transition group-out:duration-300 group-out:opacity-0 group-out-before:-translate-x-4 group-out-after:translate-x-4">
      <div class="py-2 px-2.5 text-xs">${tooltip}</div>
    </div>
  </div>
</div>
