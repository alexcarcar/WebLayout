const nums = [5,4,7,2,3,3,4];
nums.sort();
n = nums.length;
var max = nums[n-1];
for (i=n-2; i>=0; i--) {
	if (nums[i]<max) {
		console.log(nums[i]);
		break;
	}
}
